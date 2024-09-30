import random

def simulate_game():
    # 1: represents a white ball, 0: represents a black ball
    balls = [1, 1, 0, 0, 0, 0]  # 2 white balls and 4 black balls
    random.shuffle(balls)  # Shuffle the balls randomly
    
    # A picks first
    a_pick = balls.pop(0)  # A picks the first ball
    if a_pick == 1:
        return True  # A wins if A picks a white ball
    
    # B picks next
    b_pick = balls.pop(0)  # B picks the second ball
    if b_pick == 1:
        return False  # B wins if B picks a white ball
    
    # If both A and B pick black balls, A picks again
    a_pick = balls.pop(0)  # A picks again
    if a_pick == 1:
        return True  # A wins if A picks a white ball
    
    # If all picks fail, B will eventually win
    return False  # B wins if the game reaches this point

def simulate_games(n):
    a_wins = 0
    for _ in range(n):
        if simulate_game():
            a_wins += 1
    return a_wins / n

# Simulate 100,000 games to estimate the probability
n_simulations = 10000000
estimated_probability = simulate_games(n_simulations)
print(f"Estimated probability for A to win: {estimated_probability:.4f}")
import random

def simulate_draws(num_simulations):
    a_wins = 0

    for _ in range(num_simulations):
        urn = ['white', 'white', 'black', 'black', 'black', 'black']
        random.shuffle(urn)

        # A's turn
        a_draw = urn.pop()
        if a_draw == 'white':
            a_wins += 1
            continue

        # B's turn
        b_draw = urn.pop()
        if b_draw == 'white':
            continue

        # A's second turn
        a_draw = urn.pop()
        if a_draw == 'white':
            a_wins += 1
            continue

        # B's second turn
        b_draw = urn.pop()
        if b_draw == 'white':
            continue

        # A's third turn
        a_draw = urn.pop()
        if a_draw == 'white':
            a_wins += 1

    return a_wins / num_simulations

# Run the simulation with a large number of trials
num_simulations = 100000000
estimated_probability = simulate_draws(num_simulations)
print(f"Estimated probability that A wins: {estimated_probability:.4f}")
