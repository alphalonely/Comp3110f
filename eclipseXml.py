from typing import Dict, List, Tuple, Optional
import xml.etree.ElementTree as ET


def getVersions(xmlFile: str) -> List[Tuple[int, bool]]:

    xmlTree = ET.parse(xmlFile)
    xmlRoot = xmlTree.getroot()

    versionList: List[Tuple[int, bool]] = []

    for versionElement in xmlRoot.findall("VERSION"):
        numberString = versionElement.get("NUMBER")
        checkedString = versionElement.get("CHECKED", "FALSE")
        if numberString is None:
            continue
        versionNumber = int(numberString)
        isChecked = checkedString.upper() == "TRUE"
        versionList.append((versionNumber, isChecked))

    return versionList


def loadVersionMapping(
    xmlFile: str,
    versionNumber: int,
) -> Dict[int, Optional[int]]:

    xmlTree = ET.parse(xmlFile)
    xmlRoot = xmlTree.getroot()

    targetVersionElement: Optional[ET.Element] = None
    for versionElement in xmlRoot.findall("VERSION"):
        numberString = versionElement.get("NUMBER")
        if numberString is not None and int(numberString) == versionNumber:
            targetVersionElement = versionElement
            break

    mappingDict: Dict[int, Optional[int]] = {}

    if targetVersionElement is None:
        return mappingDict

    for locationElement in targetVersionElement.findall("LOCATION"):
        origString = locationElement.get("ORIG")
        newString = locationElement.get("NEW")
        if origString is None or newString is None:
            continue

        oldLine = int(origString)
        if newString == "-1":
            mappingDict[oldLine] = None
        else:
            mappingDict[oldLine] = int(newString)

    return mappingDict