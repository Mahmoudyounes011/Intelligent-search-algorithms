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
def generate_throws(current_throw, current_sequence, all_sequences,cumulative_prob):
    if current_throw == 10:
        if cumulative_prob > 0.0001:
            all_sequences.append((current_sequence,cumulative_prob))
        return
    for stone in stones:
        next_prob = stone_probabilities[stone]
        if cumulative_prob * next_prob > 0.0001:
            if stone in ['dist', 'bnj', 'sheqah', 'bara']:
                generate_throws(current_throw + 1, current_sequence + [stone], all_sequences,cumulative_prob * next_prob)
            else:
                all_sequences.append((current_sequence+[stone],cumulative_prob*stone_probabilities[stone])) 
    return         

# Initial call to the function
all_sequences = []
generate_throws(0, [], all_sequences,1)

# Print all possible sequences
# for sequence,prob in all_sequences:
#     print(f"Sequence: {sequence}, Probability: {prob:.2%}")


print(f"Number of sequences with a probability > 0.0001: {len(all_sequences)}")
