from typing import List


def editDistance(strA: str, strB: str) -> int:
    lenA = len(strA)
    lenB = len(strB)

    if lenA == 0:
        return lenB
    if lenB == 0:
        return lenA

    dpTable: List[List[int]] = [[0] * (lenB + 1) for _ in range(lenA + 1)]

    for row in range(lenA + 1):
        dpTable[row][0] = row
    for col in range(lenB + 1):
        dpTable[0][col] = col

    for row in range(1, lenA + 1):
        charA = strA[row - 1]
        for col in range(1, lenB + 1):
            charB = strB[col - 1]

            cost = 0 if charA == charB else 1

            deleteCost = dpTable[row - 1][col] + 1
            insertCost = dpTable[row][col - 1] + 1
            replaceCost = dpTable[row - 1][col - 1] + cost

            dpTable[row][col] = min(deleteCost, insertCost, replaceCost)

    return dpTable[lenA][lenB]


def similarity(strA: str, strB: str) -> float:
    maxLen = max(len(strA), len(strB))
    if maxLen == 0:
        return 1.0
    distance = editDistance(strA, strB)
    return 1.0 - distance / maxLen