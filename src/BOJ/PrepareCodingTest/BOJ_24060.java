package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_24060 {

    static int[] tmp;
    static int count = 0;
    static int result = -1;
    static int K;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        tmp = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(arr, 0, arr.length-1);
        System.out.print(result);
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;      // q는 p, r의 중간 지점
            mergeSort(arr, l, mid);      // 전반부 정렬
            mergeSort(arr, mid + 1, r);  // 후반부 정렬
            merge(arr, l, mid, r);        // 병합
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int t = 0;

        //배열에서 비교하고 작은 쪽 tmp배열에 저장
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) { //A배열에 i번째 tmp배열에 저장
                tmp[t++] = arr[i++]; //i번째 저장하고 다음 t, i로 넘어감
            }
            else { //배열에 j번째 tmp배열에 저장
                tmp[t++] = arr[j++]; //j번째 저장했으므로 다음 t, j로 넘어감
            }
        }
        while (i <= mid)  //왼쪽 배열 부분이 남은 경우
            tmp[t++] = arr[i++];
        while (j <= right)  //오른쪽 배열 부분이 남은 경우
            tmp[t++] = arr[j++];

        i = left;
        t = 0;
        while (i <= right) { //tmp에 저장한 결과를 A[p..r]에 저장
            count++;
            if(count==K) { //K번째로 저장
                result = tmp[t]; //K번째로 저장되는 수
                break;
            }
            arr[i++] = tmp[t++];
        }
    }
}
