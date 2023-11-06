class FileSystem {
    class Directory {
        Map<String, Directory> dir = new HashMap<>();
        Map<String, String> files = new HashMap<>();
    }

    Directory root;

    
    public FileSystem() {
        root = new Directory();
    }
    
    public List<String> ls(String path) {
        List<String> ans = new ArrayList<>();
        Directory currDirectory = root;
        if(!path.equals("/")) {
            String[] pathArray = path.split("/");
            int i = 1;
            while(i < pathArray.length - 1) {
                currDirectory = currDirectory.dir.get(pathArray[i]);
                i++;
            }
            if(currDirectory.files.containsKey(pathArray[i])) {
                ans.add(pathArray[i]);
                return ans;
            } else {
                currDirectory = currDirectory.dir.get(pathArray[i]);
            }
        }
        for(Map.Entry<String, Directory> entry: currDirectory.dir.entrySet()) {
            ans.add(entry.getKey());
        }
        for(Map.Entry<String, String> entry: currDirectory.files.entrySet()) {
            ans.add(entry.getKey());
        }
        Collections.sort(ans);
        return ans;
    }
    
    public void mkdir(String path) {
        String[] pathArray = path.split("/");
        int i = 1;
        Directory currDirectory = root;
        while(i < pathArray.length) {
            if(!currDirectory.dir.containsKey(pathArray[i])) {
                currDirectory.dir.put(pathArray[i], new Directory());
            }
            currDirectory = currDirectory.dir.get(pathArray[i]);
            i++;
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        String[] pathArray = filePath.split("/");
        int i = 1;
        Directory currDirectory = root;
        while(i < pathArray.length - 1) {
            currDirectory = currDirectory.dir.get(pathArray[i]);
            i++;
        }
        currDirectory.files.put(pathArray[i], currDirectory.files.getOrDefault(pathArray[i], "") + content);
    }
    
    public String readContentFromFile(String filePath) {
        String[] pathArray = filePath.split("/");
        int i = 1;
        Directory currDirectory = root;
        while(i < pathArray.length - 1) {
            currDirectory = currDirectory.dir.get(pathArray[i]);
            i++;
        }
        if(currDirectory.files.containsKey(pathArray[i])) {
            return currDirectory.files.get(pathArray[i]);
        } else return "";
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */