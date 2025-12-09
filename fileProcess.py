from typing import List, Optional, Tuple


def loadFile(
    inputFile: str,
    strip: bool = True,
    toLower: bool = True,
    enc: str = "utf-8",
) -> List[str]:
    lines: List[str] = []
    with open(inputFile, "r", encoding=enc) as fileHandle:
        for line in fileHandle:
            text = line.rstrip("\r\n")
            if strip:
                text = text.strip()
            if toLower:
                text = text.lower()
            lines.append(text)
    return lines


def finalOutput(
    mappingList: List[Tuple[int, Optional[int]]],
    outputFile: Optional[str] = None,
    enc: str = "utf-8",
) -> None:

    if outputFile is None:

        outputFile = "simpleOut.csv"

    with open(outputFile, "w", encoding=enc) as fileHandle:

        fileHandle.write("old,new\n")

        for oldLine, newLine in mappingList:
            if newLine is None:
                newStr = "X"
            else:
                newStr = str(newLine)
            fileHandle.write(f"{oldLine},{newStr}\n")