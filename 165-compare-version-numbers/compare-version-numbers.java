class Solution {
    public int compareVersion(String version1, String version2) {
        String[] ver1Split = version1.split("\\.");
        String[] ver2Split = version2.split("\\.");
        for(int i=0; i<Math.max(ver1Split.length, ver2Split.length); i++) {
            int ver1 = i < ver1Split.length ? Integer.valueOf(ver1Split[i]) : 0;
            int ver2 = i < ver2Split.length ? Integer.valueOf(ver2Split[i]) : 0;
            System.out.println("1 " + ver1 + " 2 " + ver2);
            if(ver1 > ver2) return 1;
            else if (ver2 > ver1) return -1;
        }
        return 0;
    }
}