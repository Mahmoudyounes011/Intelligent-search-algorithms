def generate_throws(throws_left, current_sequence, all_sequences):
    stones = ['dist', 'bnj', 'sheqah', 'bara', 'dowaq', 'three', 'four']
    
    if throws_left == 0 or current_sequence[-4:] == ['dist', 'bnj', 'sheqah', 'bara']:
        all_sequences.append(current_sequence)
        return
    
    for stone in stones:
        generate_throws(throws_left - 1, current_sequence + [stone], all_sequences)

# Initial call to the function
all_sequences = []
generate_throws(2, [], all_sequences)
print(len( all_sequences))
# Print all possible sequences
# for sequence in all_sequences:
#     print(sequence)