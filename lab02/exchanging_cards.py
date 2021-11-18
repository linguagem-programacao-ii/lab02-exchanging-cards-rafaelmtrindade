def lines_from(path: str):
    with open(path, mode='r') as file:
        file_lines = file.readlines()
        for line in file_lines:
            yield line
    raise StopIteration


def write_to(path: str, text: list[str]):
    with open(path, mode='w') as file:
        for line in text:
            file.write(line+'\n') if not line == text[-1] else file.write(line)


manual_test = False

in_source = lines_from('./tests/01.in')
out_path = './tests/01test.out'

results = []
while True:
    in_data = next(in_source) if not manual_test else input()
    if in_data == '0 0':
        break

    alices_unique_cards = set(map(int, next(in_source).split() if not manual_test else input().split()))
    bettys_unique_cards = set(map(int, next(in_source).split() if not manual_test else input().split()))

    max_trades_alice = len(alices_unique_cards.difference(bettys_unique_cards))
    max_trades_betty = len(bettys_unique_cards.difference(alices_unique_cards))

    results.append(str(min(max_trades_alice, max_trades_betty)))

# print(*results, sep='\n')
write_to(out_path, results)