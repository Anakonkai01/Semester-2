import itertools

def exercise1():
    A = {1,2,3,4,5}
    k = 3
    num_3_digits = list(itertools.permutations(A,k))
    num_length = len(num_3_digits)
    print("List of 3-digit numbers can be formed from the digits in set A without repetitions are: ",num_3_digits)
    print("Length of the list are: ",num_length)

def exercise2():
    def cross(A,B):
        return {a + b for a in A for b in B}

    whiteBalls = list(cross('W', '12345678'))
    redBalls =  list(cross('R', '123456789'))
    blackBalls = list(cross('B', '123456'))
    urn = whiteBalls + redBalls + blackBalls
    
    # a
    U3 = list(itertools.combinations(urn,3))
    print("2a:")
    print("List of U3:")
    for i in U3:
        print(i)
    len_U3 = len(U3)
    print("Length of U3: ",len_U3)

    # b
    print("2b:")
    differ_colors_U3 = []  

    for s in U3:
        colors = list(ball[0] for ball in s)
        if len(colors) == 3:
            differ_colors_U3.append(s)

    for s in differ_colors_U3:
        print(s)
    print("Total different Arrangement: ",len(differ_colors_U3))

    # c
    print("2c:")
    for s in U3:
        if s[0][0]=='W' and s[1][0]=='R':
            print(s)

def exercise3():
    def cross(A, B):
        return {a + b for a in A for b in B}

    maths = list(cross('M', '1234'))         
    physics = list(cross('P', '123'))        
    chemistry = list(cross('C', '12'))       
    language = list(cross('L', '1'))        

    groups = [maths, physics, chemistry, language]
    print(groups)

    groups_permutation = itertools.permutations(groups) # chinh hop cho 4 vi tri xap xep =  4!
    
    total_diff = 0

    for group_order in groups_permutation:
        perm_math = list(itertools.permutations((group_order[0]))) # chinh hop cho math 4!
        perm_physics = list(itertools.permutations((group_order[1]))) # chinh hop cho phy 3!
        perm_chemistry = list(itertools.permutations((group_order[2]))) # chinh hop cho che 2!
        perm_language = list(itertools.permutations((group_order[3]))) 

        for math_perm in perm_math: # long ghep vao : 4!*3!*2!*1!
            for physics_perm in perm_physics:
                for chemistry_perm in perm_chemistry:
                    for language_perm in perm_language:
                        full_arrangement = math_perm + physics_perm + chemistry_perm + language_perm
                        total_diff += 1
                        print(full_arrangement)
        print(group_order)

    print("Total arrangement: ",total_diff)

    

def exercise4():
    def cross(A, B):
        return {a + b for a in A for b in B}

    groups_men = list(cross('M','123456')) 
    groups_women = list(cross('W','123456789'))
    
    total_diff = 0
    comb_men = list(itertools.combinations(groups_men,3)) # 6C3
    comb_women = list(itertools.combinations(groups_women,2)) # 9C2

    for men_comb in comb_men: # 6C3* 9C2
        for women_comb in comb_women:
            fullArrangement = men_comb + women_comb
            print(fullArrangement)
            total_diff += 1

    print("Total different arrangemet :",total_diff)

def exercise5():
    def cross(A, B):
        return {a + b for a in A for b in B}
    cards = ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K']
    suits = ['spades', 'clubs', 'diamonds', 'hearts']

    deck = list(cross(cards,suits))


exercise5()