package First;

class Solution extends VersionControl{
	public int firstBadVersion(int n) {
        int l=1;
        int h = n;
        while(l<h){
            int mid = (l+h)/2;
            if(isBadVersion(mid)){
                h=mid;
            }else{
                l=mid+1;
            }
        }
    }
}