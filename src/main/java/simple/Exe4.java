package simple;

/**
 * Created by linc on 2018/9/14.
 */
public class Exe4 {

    public static void main(String[] args){
        int[] nums1={1,2};
        int[] nums2={3,4};
        new Exe4().findMedianSortedArrays(nums1,nums2);
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int m = total % 2;
        int length = total / 2 + 1;
        int i1 = 0, i2 = 0;
        int v1 = 0, v2 = 0;
        for (int i = 0; i < length; i++) {
            int min;
            if (i1 < nums1.length && i2 < nums2.length) {
                if (nums1[i1] < nums2[i2]) {

                    min = nums1[i1];
                    i1++;
                } else {

                    min = nums2[i2];
                    i2++;
                }
            } else {
                if (i1 < nums1.length) {

                    min = nums1[i1];
                    i1++;
                } else {

                    min = nums2[i2];
                    i2++;
                }
            }
            if (i == length - 2)
                v1 = min;
            if (i == length - 1)
                v2 = min;
        }

        if (m == 0) {
            return (v1 + v2) / 2d;
        } else {
            return v2;
        }
    }

}
