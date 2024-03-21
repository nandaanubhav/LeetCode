class Logger {
    Map<String, Integer> logs;
    public Logger() {
        logs = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!logs.containsKey(message)) {
            logs.put(message, timestamp);
            return true;
        } else {
            int lastTimestamp = logs.get(message);
            if(timestamp - lastTimestamp >= 10) {
                logs.put(message, timestamp);
                return true;
            } else return false;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */