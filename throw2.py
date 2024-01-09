stones = ['dist', 'bnj', 'sheqah', 'bara', 'dowaq', 'three', 'four']
stone_probabilities = {
    'dist': 0.186624,  
    'bnj': 0.0368864,  
    'sheqah': 0.046656,
    'bara': 0.004096,
    'dowaq': 0.31104,
    'three': 0.27648,
    'four': 0.13824
}
def generate_throws(current_throw, current_sequence, all_sequences,):
    if current_throw == 10:
        all_sequences.append((current_sequence))
        return
    for stone in stones:
        next_prob = stone_probabilities[stone]
        if stone in ['dist', 'bnj', 'sheqah', 'bara']:
            generate_throws(current_throw + 1, current_sequence + [stone], all_sequences)
        else:
            all_sequences.append((current_sequence+[stone])) 
    return         

all_sequences = []
generate_throws(0, [], all_sequences)

# Print all possible sequences
# for sequence in all_sequences:
#     print(f"Sequence: {sequence}")


print(f"Number of sequences before remove: {len(all_sequences)}")

unique_sublists = set(tuple(sorted(sublist)) for sublist in all_sequences)

result = [list(sublist) for sublist in unique_sublists]

for sequence in all_sequences:
    print(f"Sequence: {sequence}")
    
print( len( result))
