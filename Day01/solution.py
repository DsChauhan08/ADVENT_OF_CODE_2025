#!/usr/bin/env python3
"""
Advent of Code 2025 - Day 01 Solution
https://adventofcode.com/2025/day/1
"""


def parse_input(filename: str) -> str:
    """Read and parse the input file."""
    with open(filename, 'r') as f:
        return f.read().strip()


def part1(data: str) -> int:
    """Solve Part 1 of the puzzle."""
    # TODO: Implement solution for Part 1
    pass


def part2(data: str) -> int:
    """Solve Part 2 of the puzzle."""
    # TODO: Implement solution for Part 2
    pass


def main():
    """Main function to run the solutions."""
    data = parse_input('input.txt')
    
    print("Advent of Code 2025 - Day 01")
    print("-" * 40)
    
    result1 = part1(data)
    print(f"Part 1: {result1}")
    
    result2 = part2(data)
    print(f"Part 2: {result2}")


if __name__ == "__main__":
    main()
