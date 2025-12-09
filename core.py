from typing import Dict, List, Optional, Set, Tuple

from similarity import similarity


def exactMatch(
    oldLines: List[str],
    newLines: List[str],
) -> Tuple[Dict[int, int], Set[int]]:

    from collections import defaultdict

    textToNewIndices: Dict[str, List[int]] = defaultdict(list)
    for newIndex, text in enumerate(newLines):
        textToNewIndices[text].append(newIndex)

    mappingDict: Dict[int, int] = {}
    usedNewIndices: Set[int] = set()

    for oldIndex, text in enumerate(oldLines):
        candidateIndices = textToNewIndices.get(text)
        if not candidateIndices:
            continue

        chosenIndex: Optional[int] = None
        for newIndex in candidateIndices:
            if newIndex not in usedNewIndices:
                chosenIndex = newIndex
                break

        if chosenIndex is not None:
            mappingDict[oldIndex] = chosenIndex
            usedNewIndices.add(chosenIndex)

    return mappingDict, usedNewIndices


def Mapping(
    oldLines: List[str],
    newLines: List[str],
    similarityLevel: float = 0.6,
) -> List[Tuple[int, Optional[int]]]:

    countOld = len(oldLines)
    countNew = len(newLines)

    exactMapping, usedNewIndices = exactMatch(oldLines, newLines)

    mappingZeroBased: Dict[int, Optional[int]] = {}

    for oldIndex, newIndex in exactMapping.items():
        mappingZeroBased[oldIndex] = newIndex

    for oldIndex in range(countOld):
        if oldIndex in mappingZeroBased:
            continue

        bestNewIndex: Optional[int] = None
        bestScore: float = -1.0

        for newIndex in range(countNew):
            if newIndex in usedNewIndices:
                continue

            score = similarity(oldLines[oldIndex], newLines[newIndex])
            if score > bestScore:
                bestScore = score
                bestNewIndex = newIndex

        if bestNewIndex is not None and bestScore >= similarityLevel:
            mappingZeroBased[oldIndex] = bestNewIndex
            usedNewIndices.add(bestNewIndex)
        else:
            mappingZeroBased[oldIndex] = None

    result: List[Tuple[int, Optional[int]]] = []
    for oldIndex in sorted(mappingZeroBased.keys()):
        oldLineNumber = oldIndex + 1
        newIndex = mappingZeroBased[oldIndex]
        if newIndex is None:
            result.append((oldLineNumber, None))
        else:
            result.append((oldLineNumber, newIndex + 1))

    return result
