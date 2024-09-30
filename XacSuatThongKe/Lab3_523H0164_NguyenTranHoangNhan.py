import itertools
import fractions
import random


# def P(event, space):
#     return Fraction(len(event & space), len(space))
#
# S = {'BB', 'BG', 'GB', 'GG'}
#
# B = {s for s in S if 'B' in s}
# A_B = {s for s in B if s.count('B') == 2}
#
# P_B = P(B, S)
# P_A_B = P(A_B, S)
#
# P_A_with_B = P_A_B / P_B
# print(P_A_with_B)


# a
def exercise1():
    S = [''.join(combo) for combo in itertools.product('MF', repeat=3)]

    def a():
        print(S)
        return S

    def b():
        return len(a())

    def c():
        B = [combo for combo in S if 'F' in combo]
        print(B)
        return B

    def d():
        A = [combo for combo in S if combo == 'FFF']
        print(A)
        return A

    def e():
        def P(event, space):
            return fractions.Fraction(len(event & set(space)), len(space))

        P_A_given_B = P(set(d()), c())

        print(f"P(A|B) = {P_A_given_B}")
        return P_A_given_B

    print("a: ")
    a()
    print("b: ")
    b()
    print("c: ")
    c()
    print("d: ")
    d()
    print("e: ")
    e()


def exercise2():
    S = [('Thanh', 'Nữ'), ('Hồng', 'Nữ'), ('Thương', 'Nữ'), ('Đào', 'Nữ'), ('My', 'Nữ'),
         ('Yến', 'Nữ'), ('Hạnh', 'Nữ'), ('My', 'Nữ'), ('Vy', 'Nữ'), ('Tiên', 'Nữ'),
         ('Thanh', 'Nam'), ('Thanh', 'Nam'), ('Bình', 'Nam'), ('Nhật', 'Nam'),
         ('Hào', 'Nam'), ('Đạt', 'Nam'), ('Minh', 'Nam')]

    def a():
        return [student for student in S if student[1] == 'Nữ']

    def b():
        return [student for student in S if student[0] == 'Thanh']

    def c():
        return [student for student in S if student[1] == 'Nữ' and student[0] == 'Thanh']

    def calculate_probability(event, space):
        return fractions.Fraction(len(event), len(space))

    P_A = calculate_probability(a(), S)
    P_B = calculate_probability(b(), S)
    P_A_B = calculate_probability(c(), S)

    def e():
        return fractions.Fraction(len(c()), len(a()))

    # Print results
    print("A (Females):", a())
    print("B (Named Thanh):", b())
    print("A ∩ B (Females named Thanh):", c())
    print(f"P(A) = {P_A}")
    print(f"P(B) = {P_B}")
    print(f"P(A ∩ B) = {P_A_B}")
    print(f"P(Thanh | Female) = {e()}")


def exercise3():
    # a
    suits = '♠♡♢♣'
    ranks = ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K']
    Cards = set(f'{rank}{suit}' for rank, suit in itertools.product(ranks, suits))

    # b
    B = random.sample(list(Cards), 3)

    def count_kings(hand):
        return sum(1 for card in hand if card[0] == 'K')

    # c
    A1 = set(hand for hand in itertools.combinations(Cards, 3) if count_kings(hand) in [1, 2])

    # d
    A2 = set(hand for hand in itertools.combinations(Cards, 3) if count_kings(hand) >= 1)

    # e
    def calculate_probability(event, space):
        return fractions.Fraction(len(event), len(space))

    total_hands = set(itertools.combinations(Cards, 3))
    P_A1 = calculate_probability(A1, total_hands)
    P_A2 = calculate_probability(A2, total_hands)

    print(f"Total cards: {len(Cards)}")
    print(f"Randomly selected 3 cards (B): {B}")
    print(f"Number of hands in A1 (1 or 2 Kings): {len(A1)}")
    print(f"Number of hands in A2 (at least 1 King): {len(A2)}")
    print(f"P(A1) = {P_A1}")
    print(f"P(A2) = {P_A2}")


def bayes_theorem(prior, sensitivity, false_positive_rate):
    return (prior * sensitivity) / (prior * sensitivity + (1 - prior) * false_positive_rate)


# 1. Email Spam Detection
def exercise4():
    p_spam = 0.20
    p_marked_if_spam = 0.95
    p_marked_if_not_spam = 0.02

    p_spam_if_marked = bayes_theorem(p_spam, p_marked_if_spam, p_marked_if_not_spam)
    print(f"Probability of email being spam if marked as spam: {p_spam_if_marked:.4f}")


# 2. Medical Test
def exercise5():
    p_disease = 0.02
    p_positive_if_disease = 0.90
    p_positive_if_no_disease = 0.05

    p_disease_if_positive = bayes_theorem(p_disease, p_positive_if_disease, p_positive_if_no_disease)
    print(f"Probability of having the disease if tested positive: {p_disease_if_positive:.4f}")


# 3. Genetic Testing
def exercise6():
    p_marker = 0.01
    sensitivity = 0.98
    specificity = 0.97
    false_positive_rate = 1 - specificity

    p_marker_if_positive = bayes_theorem(p_marker, sensitivity, false_positive_rate)
    print(f"Probability of having the genetic marker if tested positive: {p_marker_if_positive:.4f}")


# 4. Quality Control in Manufacturing
def exercise7():
    p_defective = 0.05
    p_test_positive_if_defective = 0.90
    p_test_positive_if_not_defective = 0.04

    p_defective_if_positive = bayes_theorem(p_defective, p_test_positive_if_defective, p_test_positive_if_not_defective)
    print(f"Probability of product being defective if tested positive: {p_defective_if_positive:.4f}")


# 5. Multiple Diagnostic Tests for a Disease
def exercise8():
    p_disease_y = 0.02
    sensitivity_1, specificity_1 = 0.90, 0.85
    sensitivity_2, specificity_2 = 0.80, 0.90
    sensitivity_3, specificity_3 = 0.85, 0.80

    # After Test 1 (positive)
    p_disease_after_test1 = bayes_theorem(p_disease_y, sensitivity_1, 1 - specificity_1)

    # After Test 2 (negative)
    p_disease_after_test2 = p_disease_after_test1 * (1 - sensitivity_2) / (
                p_disease_after_test1 * (1 - sensitivity_2) + (1 - p_disease_after_test1) * specificity_2)

    # After Test 3 (positive)
    p_disease_after_test3 = bayes_theorem(p_disease_after_test2, sensitivity_3, 1 - specificity_3)

    print(f"Probability of having Disease Y after all three tests: {p_disease_after_test3:.4f}")


print("exercise1: ")
exercise1()
print()
print("exercise2: ")
exercise2()
print()
print("exercise3: ")
exercise3()
print()
print("exercise4: ")
exercise4()
print()
print("exercise5: ")
exercise5()
print()
print("exercise6: ")
exercise6()
print()
print("exercise7: ")
exercise7()
print()
print("exercise8: ")
exercise8()

