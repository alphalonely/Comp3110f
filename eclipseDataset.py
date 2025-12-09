import os
from typing import Tuple, List

from fileProcess import loadFile
from core import Mapping
from eclipseXml import getVersions, loadVersionMapping


def evaluatePair(
    oldFile: str,
    newFile: str,
    xmlFile: str,
    versionNumber: int,
    similarityLevel: float,
) -> Tuple[int, int]:
    oldLines = loadFile(oldFile)
    newLines = loadFile(newFile)

    mappingList = Mapping(oldLines, newLines, similarityLevel=similarityLevel)
    predictedDict = {oldLine: newLine for (oldLine, newLine) in mappingList}

    groundTruthDict = loadVersionMapping(xmlFile, versionNumber)

    totalCount = len(groundTruthDict)
    correctCount = 0

    for oldLine, groundTruthNewLine in groundTruthDict.items():
        predictedNewLine = predictedDict.get(oldLine)
        if predictedNewLine == groundTruthNewLine:
            correctCount += 1

    return correctCount, totalCount


def main() -> None:
    currentDir = os.path.dirname(os.path.abspath(__file__))
    rootDir = os.path.join(currentDir, "eclipseTest")

    similarityLevel = 0.8

    xmlFiles = sorted(
        f for f in os.listdir(rootDir) if f.lower().endswith(".xml")
    )

    totalCorrect = 0
    totalLines = 0

    rows: List[Tuple[str, str, float, int, int]] = []

    for xmlName in xmlFiles:
        xmlFile = os.path.join(rootDir, xmlName)
        baseName = os.path.splitext(xmlName)[0]

        versionList = getVersions(xmlFile)

        for versionNumber, isChecked in versionList:
            if versionNumber == 1:
                continue
            if not isChecked:
                continue

            oldFile = os.path.join(rootDir, f"{baseName}_1.java")
            newFile = os.path.join(rootDir, f"{baseName}_{versionNumber}.java")

            correctCount, totalCount = evaluatePair(
                oldFile, newFile, xmlFile, versionNumber, similarityLevel
            )

            totalCorrect += correctCount
            totalLines += totalCount

            if totalCount > 0:
                percent = 100.0 * correctCount / totalCount
            else:
                percent = 0.0

            rows.append((baseName, f"v{versionNumber}", percent, correctCount, totalCount))

    Percent = 0.0
    if totalLines > 0:
        Percent = 100.0 * totalCorrect / totalLines

    outputFile = os.path.join(currentDir, "testEclipse.csv")
    with open(outputFile, "w", encoding="utf-8") as outHandle:
        outHandle.write("file,version,percent,correct,total\n")
        for fileName, versionStr, percent, correct, total in rows:
            outHandle.write(f"{fileName},{versionStr},{percent:.1f},{correct},{total}\n")

        if totalLines > 0:
            outHandle.write(f"Overall,,{Percent:.1f},{totalCorrect},{totalLines}\n")


if __name__ == "__main__":
    main()