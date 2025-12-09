import os
from typing import Dict, Optional, Tuple, List

from fileProcess import loadFile
from core import Mapping


def loadGroundTruthMappingFromCsv(csvFile: str) -> Dict[int, Optional[int]]:

    mappingDict: Dict[int, Optional[int]] = {}

    with open(csvFile, "r", encoding="utf-8") as fileHandle:
        firstLine = True
        for line in fileHandle:
            text = line.strip()
            if not text:
                continue

            if firstLine:
                firstLine = False
                continue

            parts = text.split(",")
            if len(parts) != 2:
                continue

            oldStr = parts[0].strip()
            newStr = parts[1].strip()

            if not oldStr:
                continue

            oldLine = int(oldStr)

            if newStr.upper() == "X":
                mappingDict[oldLine] = None
            else:
                mappingDict[oldLine] = int(newStr)

    return mappingDict


def evaluatePair(
    oldFile: str,
    newFile: str,
    csvFile: str,
    similarityLevel: float,
) -> Tuple[int, int]:

    oldLines = loadFile(oldFile)
    newLines = loadFile(newFile)

    mappingList = Mapping(oldLines, newLines, similarityLevel=similarityLevel)
    predictedDict = {oldLine: newLine for (oldLine, newLine) in mappingList}

    groundTruthDict = loadGroundTruthMappingFromCsv(csvFile)

    totalCount = len(groundTruthDict)
    correctCount = 0

    for oldLine, groundTruthNewLine in groundTruthDict.items():
        predictedNewLine = predictedDict.get(oldLine)
        if predictedNewLine == groundTruthNewLine:
            correctCount += 1

    return correctCount, totalCount


def main() -> None:
    currentDir = os.path.dirname(os.path.abspath(__file__))
    datasetDir = os.path.join(currentDir, "newDataset")

    similarityLevel = 0.6


    csvFiles = sorted(
        f for f in os.listdir(datasetDir) if f.lower().endswith(".csv")
    )

    totalCorrect = 0
    totalLines = 0


    rows: List[Tuple[str, float, int, int]] = []

    for csvName in csvFiles:
        csvFile = os.path.join(datasetDir, csvName)
        baseName = os.path.splitext(csvName)[0]

        oldFile = os.path.join(datasetDir, f"{baseName}_old.java")
        newFile = os.path.join(datasetDir, f"{baseName}_new.java")

        correctCount, totalCount = evaluatePair(
            oldFile, newFile, csvFile, similarityLevel
        )

        totalCorrect += correctCount
        totalLines += totalCount

        if totalCount > 0:
            percent = 100.0 * correctCount / totalCount
        else:
            percent = 0.0

        rows.append((baseName, percent, correctCount, totalCount))

    overallPercent = 0.0
    if totalLines > 0:
        overallPercent = 100.0 * totalCorrect / totalLines

    outputFile = os.path.join(currentDir, "testMyDataset.csv")
    with open(outputFile, "w", encoding="utf-8") as outHandle:
        outHandle.write("file,percent,correct,total\n")
        for fileName, percent, correct, total in rows:
            outHandle.write(f"{fileName},{percent:.1f},{correct},{total}\n")

        if totalLines > 0:
            outHandle.write(f"Overall,{overallPercent:.1f},{totalCorrect},{totalLines}\n")


if __name__ == "__main__":
    main()