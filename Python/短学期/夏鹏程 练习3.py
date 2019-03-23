def reversalString(s):
    j = len(s)
    p = []
    for i in range(j):
        p.append('0')
    for i in range(j):
        p[j-1-i] = s[i]
    l = ''.join(p)
    return l

l = 'Hello World!'
print(reversalString(l))