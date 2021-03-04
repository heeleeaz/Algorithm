class PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int l=0, h = arr.length -1;
        while(l<=h){
            int pivot = l + (h-l)/2;
            if(arr[pivot] < arr[pivot+1]){
                l = pivot + 1;
            }else{
                h = pivot -1;
            }
        }
        
        return l;
    }
}