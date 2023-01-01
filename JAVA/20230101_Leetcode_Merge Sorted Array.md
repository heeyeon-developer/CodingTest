# Sorting and Searching
1. 주어진 2개의 증가배열 nums1, nums2에 존재하는 숫자의 갯수 m,n을 합친 숫자만큼 temp 배열 만들기
2. while문을 이용해서 nums1,nums2를 비교하여 작은 숫자부터 temp에 담기
3. 만약 nums1,nums2의 길이를 넘어갈 경우 if(idx1 == m), if(idx2 == n)을 이용하여 예외처리
4. 각 배열의 길이를 넘어갈 경우 나머지 배열만 이용하여 temp에 숫자 추가
5. temp에 모든 숫자를 담은 결과를 nums1에 담기


```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m+n];
        int idx1 = 0, idx2 = 0, idx = 0;
        
        while(idx < m+n){
            if(idx1 == m){
                temp[idx++] = nums2[idx2++];
                continue;
            }else if(idx2 == n){
                temp[idx++] = nums1[idx1++];
                continue;
            }
            
            if(nums1[idx1] < nums2[idx2]){
                temp[idx++] = nums1[idx1++];
            }else{
                temp[idx++] = nums2[idx2++];
            }
        }
        
        for(int i=0; i<m+n; i++){
            nums1[i] = temp[i];
        }
    }
}
```
