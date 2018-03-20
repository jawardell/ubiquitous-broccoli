var('g, s, D')

def start_diag(g, s, D):
    y0 = 1 - 2*D
    L0 = 2*g + D
    if s == 0:
        x = 0
        y = y0
    elif s > 0:
        x = 2*g
        y = 2*g - 2*D - 1
    else:
        print("Error")
        return
    return (x, y)

def end_diag(g, s, D):
    y0 = 1 - 2*D
    L0 = 2*g + D
    if s == 0:
        x = L0 - 1
        y = y0 + L0 - 1
    elif s > 0:
        x = 2*g + D + 3
        y = 2*g - D + 2
    else:
        print("Error")
        return
    return (x, y)

g = 2; s = 1
[ [start_diag(g, s, D), end_diag(g, s, D)] for D in range(5)]

end_diag(1, 0, 0)
