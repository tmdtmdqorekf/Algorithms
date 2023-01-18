X=int(input())
N=int(input())
num=0
result=0

for i in range(N):
    a,b=input().split()
    num=int(a)*int(b)
    result+=num

if result==X:
    print('Yes')
elif result!=X:
    print('No')