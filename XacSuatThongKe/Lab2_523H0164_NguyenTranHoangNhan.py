from fractions import Fraction
import itertools
import random


# -------------- example ----------------
print()
print("example")
print()
def define_functionP():
    def P(event, space):
        return float(Fraction(len(event & space),len(space)))


    D = {1,2,3,4,5,6}
    even = {2,4,6}
    print(P(even,D))

def urn_problem():
    def P(event, space):
        return float(Fraction(len(event & space),len(space)))
    def cross(A,B):
        return {a + b for a in A for b in B}
    urn = cross('W','12345678') | cross('B','123456') | cross('R','123456789')
    print(urn)
    def combos(items,n):
        return {' '.join(combo) for combo in itertools.combinations(items,n)}

    U6 = combos(urn, 6)
    print(len(U6))
    myListt = random.sample(list(U6),10)
    print(myListt)

    red6 = {s for s in U6 if s.count('R') == 6}
    print(P(red6,U6))
    b3w2r1 = {s for s in U6 if s.count('B') == 3 and s.count('W') == 2 and s.count('R') ==1}
    print(P(b3w2r1,U6))
    w4 = {s for s in U6 if s.count('W') == 4}
    print(P(w4,U6))

def coin_experiment():
    n = 10
    count = 0
    for simulations in range(n):
        tosses = random.randint(0,1)
        if tosses == 0:
            count += 1
    print(count/n)

coin_experiment()

def dices_experiment():
    count = 0
    n = 10000
    for i in range(n):
        die1 = random.randint(1,6)
        die2 = random.randint(1,6)
        if die1 == 1 and die2 == 6:
            count += 1
    print(count/n)

dices_experiment()

def card_experiment():
    Ranks = {1,2,3,4,5,6,7,8,9,10,'j','q','k'}
    Suits = {'♡', '♢', '♣', '♠'}
    Cards = list(itertools.product(Ranks,Suits))
    print(len(Cards))
    print(Cards)

    def simulator_poker(n):
        count = 0
        for i in range(n):
            index = random.randint(0,51)
            if Cards[index][1] == '♡' or Cards[index][1] == '♢':
                count += 1
        return count/n

    print(simulator_poker(100000))


define_functionP()
urn_problem()
coin_experiment()
dices_experiment()
card_experiment()


# -------- EXERCISE -----------
print()
print("exercise")
print()
def simulator_dice1():
    n = 1000000
    count = 0
    even = {2,4,6}
    for i in range(n):
        die1 = random.randint(1,6)
        die2 = random.randint(1,6)

        if die1 in even and die2 in even:
            count += 1
    return (count/n)

def simulator_dice2():
    n = 1000000
    count = 0
    even = {2,4,6}
    odd = {1,3,5}
    for i in range(n):
        die1 = random.randint(1,6)
        die2 = random.randint(1,6)

        if die1 in even and die2 in odd:
            count += 1
    return (count/n)

def simulator_dice3():
    n = 1000000
    count = 0

    for i in range(n):
        die1 = random.randint(1,6)
        die2 = random.randint(1,6)

        if die1 == die2:
            count += 1
    return (count/n)

def simulator_dice4():
    n = 1000000
    count = 0
    for i in range(n):
        die1 = random.randint(1,6)
        die2 = random.randint(1,6)

        if die1 == 1 and die2 == 6:
            count += 1
    return (count/n)

def simulator_dice5():
    n = 1000000
    count = 0
    even = {2,4,6}
    for i in range(n):
        die1 = random.randint(1,6)
        die2 = random.randint(1,6)

        if die1 + die2 > 6:
            count += 1
    return (count/n)



def simulator_poker1(n):
    Ranks = {1,2,3,4,5,6,7,8,9,10,'j','q','k'}
    Suits = {'♡', '♢', '♣', '♠'}
    Cards = list(itertools.product(Ranks,Suits))
    count = 0
    for i in range(n):
        draw_5_cards = random.sample(Cards,5)
        
        countCheck = 0
        for card in draw_5_cards:
            if card[1] == '♡':
                countCheck += 1
        if(countCheck == 5): count += 1
    return count/n

def simulator_poker2(n):
    Ranks = {1,2,3,4,5,6,7,8,9,10,'j','q','k'}
    Suits = {'♡', '♢', '♣', '♠'}
    Cards = list(itertools.product(Ranks,Suits))
    count = 0
    for i in range(n):
        draw_5_cards = random.sample(Cards,4)
        # {card[1] for card in draw_5_cards}
        mySet = set()
        for card in draw_5_cards:
            mySet.add(card[1])                
        if len(mySet) == 4: count += 1
    return count/n

def exercise8():
    def P(event, space):
        return float(Fraction(len(event & space),len(space)))

    def cross(A,B):
        return {a + b for a in A for b in B}
    def combos(items,n):
        return {' '.join(combo) for combo in itertools.combinations(items,n)}

    urn = cross('W','12345678') | cross('B','123456') | cross('R','123456789')

    U6 = combos(urn,6)
    w2b2w2 = {s for s in U6 if s.count('W') == 2 and s.count('B') == 2 and s.count('R') == 2}
    
    return (P(w2b2w2,U6))



print("ex1")
print(simulator_dice1())
print("ex2")
print(simulator_dice2())
print("ex3")
print(simulator_dice3())
print("ex4")
print(simulator_dice4())
print("ex5")
print(simulator_dice5())
print("ex6")
n = 1000000
print(simulator_poker1(n))
print("ex7")
print(simulator_poker2(n))
print("ex8")
print(exercise8())