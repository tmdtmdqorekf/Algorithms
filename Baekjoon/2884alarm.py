hour, min=map(int, input().split()) #map함수

if min>45:
    print(hour, min-45) #45분 이상이면 45뺀 값 그대로 출력
elif hour>0 and min<45:
    print(hour-1, min+15)
else:
    print(23, min+15)