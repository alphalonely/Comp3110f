import sys

from fileProcess import loadFile, finalOutput
from core import Mapping


def main() -> None:
    # Convention:
    #   argv0 is path to old file
    #   argv1 is path to old file
    #   argv2 is path to output file
    #   argv3 is similarity level (float ex 0.1 0.2etc)
    args = sys.argv[1:]
    oldFile = args[0]
    newFile = args[1]

    outFile = "simpleOut.csv"
    if len(args) >= 3:
        outFile = args[2]

    similarityLevel = 0.6
    if len(args) >= 4:
        similarityLevel = float(args[3])

    oldLines = loadFile(oldFile)
    newLines = loadFile(newFile)

    mappingList = Mapping(oldLines, newLines, similarityLevel=similarityLevel)

    finalOutput(mappingList, outFile)


if __name__ == "__main__":
    main()

