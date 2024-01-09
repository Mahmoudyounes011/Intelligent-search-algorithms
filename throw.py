# import random

# def generate_throws(throws_left, current_sequence, all_sequences, probabilities, threshold=0.01):
#     stones = ['dist', 'bnj', 'sheqah', 'bara', 'dowaq', 'three', 'four']
    
#     # Base case: no throws left or special combination achieved
#     if throws_left == 0 or current_sequence[-4:] == ['dist', 'bnj', 'sheqah', 'bara']:
#         # Calculate the probability of the current sequence
#         sequence_probability = 1
#         for stone in current_sequence:
#             sequence_probability *= probabilities[stone]
        
#         # Only add the sequence to all_sequences if probability is above the threshold
#         if sequence_probability > threshold:
#             all_sequences.append((current_sequence, sequence_probability))
#         return
    
#     # Recursive case: try each stone and calculate probabilities
#     for stone in stones:
#         generate_throws(throws_left - 1, current_sequence + [stone], all_sequences, probabilities, threshold)

# # Define the probability for each stone
# stone_probabilities = {
#     'dist': 0.186624,  # Assuming 'dist' has a 10% chance
#     'bnj': 0.0368864,   # Assuming 'bnj' has a 15% chance, and so on
#     'sheqah': 0.046656,
#     'bara': 0.004096,
#     'dowaq': 0.31104,
#     'three': 0.27648,
#     'four': 0.13824
# }

# # Initial call to the function with a threshold of 1%
# all_sequences = []
# generate_throws(2, [], all_sequences, stone_probabilities, threshold=0.01)

# # Print the number of sequences with a probability above the threshold

# # Print all sequences with their probabilities
# for sequence, prob in all_sequences:
#     print(f"Sequence: {sequence}, Probability: {prob:.2%}")

# print(f"Number of sequences with a probability > 1%: {len(all_sequences)}")



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
    if current_throw == 3:
        if cumulative_prob > 0.01:
            all_sequences.append((current_sequence,cumulative_prob))
        return
    for stone in stones:
        next_prob = stone_probabilities[stone]
        if cumulative_prob * next_prob > 0.01:
            if stone in ['dist', 'bnj', 'sheqah', 'bara']:
                generate_throws(current_throw + 1, current_sequence + [stone], all_sequences,cumulative_prob * next_prob)
            else:
                all_sequences.append((current_sequence+[stone],cumulative_prob*stone_probabilities[stone])) 
    return         

# Initial call to the function
all_sequences = []
generate_throws(0, [], all_sequences,1)

# Print all possible sequences
for sequence,prob in all_sequences:
    print(f"Sequence: {sequence}, Probability: {prob:.2%}")


print(f"Number of sequences with a probability > 1%: {len(all_sequences)}")
