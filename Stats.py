from collections import namedtuple
import csv

Stats = namedtuple("Stats", "name team year attempts percent")

allQuarterbacks = []
with open("Career_Stats_Passing.csv", "r") as fp:
    reader = csv.DictReader(fp)
    for row in reader:
        allQuarterbacks.append(
            Stats(
                row["Name"],
                row["Team"],
                row["Year"],
                int(row["Passes Attempted"]),
                float(row["Completion Percentage"]),
            )
        )

year = input("Enter year: ")

temp = 0
for idx, quarterback in enumerate(allQuarterbacks):
    if (
        quarterback.year == year
        and quarterback.attempts >= 100
        and quarterback.percent > allQuarterbacks[temp].percent
    ):
        temp = idx

winner = allQuarterbacks[temp]

print(
    f"The Quarterback with the best completion percentage in {year} was {winner.name} with a completion percent of {winner.percent}% on the {winner.team}"
)