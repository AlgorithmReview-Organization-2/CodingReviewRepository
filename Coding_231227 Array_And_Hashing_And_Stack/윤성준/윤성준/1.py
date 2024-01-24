import sys

input=sys.stdin.readline

#round는 반올림되는 경향이있다
#입력 받을 때 참고
def main():

    trees={}
    count=0
    while 1:
        tree=input().rstrip()

        if tree=='':break
        if tree in trees:
            trees[tree]+=1
        else:
            trees[tree]=1

        count+=1


    for i in trees:
        trees[i]=round((trees[i]/count)*100,4)
    for i in sorted(trees):
        print("%s %.4f"%(i,trees[i]))

main()