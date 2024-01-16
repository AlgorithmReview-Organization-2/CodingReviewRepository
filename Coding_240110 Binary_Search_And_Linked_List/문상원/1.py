import sys

input=sys.stdin.readline

tree={}
result1=''
result2=''
result3=''


def recurA(v):
    global  result1
    result1+=v
    for i in tree[v]:
        if i!='.':
            recurA(i)



def recurB(v):
    global result2

    if tree[v][0]!='.':
        recurB(tree[v][0])

    result2 += v
    if tree[v][1] != '.':
        recurB(tree[v][1])

    return



def recurC(v):
    global result3

    if tree[v] == ('.', '.'):
        result3 += v
        return

    for i in tree[v]:
        if i != '.':
            recurC(i)
    result3 += v
    return


def main():
    #tree로 재귀
    #O(N)?
    N=int(input())
    global tree,result1,result2,result3

    for _ in range(N):
        a,b,c=map(str,input().split())

        tree[a]=(b,c)

    recurA('A')
    recurB('A')
    recurC('A')
    print(result1)
    print(result2)
    print(result3)




main()