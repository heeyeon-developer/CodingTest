# Level1

> 하샤드 수
1. 파이썬에서 정수 몫을 받기 위해서는 //를 사용하기
2. x의 각 자릿수를 더한 sum으로 x가 나누어 진다면 True 나누어지지 않는다면 False 반환


```python
def solution(x):
    num = x
    sum = 0
    while num > 0 :
        sum += num%10
        num //= 10
    return True if x%sum == 0 else False
```

> 삼총사
1. 파이썬의 모듈 중 'combinations' 를 사용하여 3개의 조합을 구하기
2. 3개의 수로 이루어진 모듈을 더해서 합이 0이 될 경우 cnt++
3. 최종 cnt 반환


```python
def solution(number):
    from itertools import combinations
    cnt = 0
    for i in combinations(number,3) :
        if sum(i) == 0 :
            cnt += 1
    return cnt
```
