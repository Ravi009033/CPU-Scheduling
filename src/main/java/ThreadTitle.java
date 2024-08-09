import javax.swing.JLabel;

public class ThreadTitle extends Thread {
    String text;
    JLabel label;
    long sleepTime;
    
    ThreadTitle(String text, JLabel label, long time) {
        this.label = label;
        this.text = text;
        sleepTime = time;
    }
    
    public void run() {
            String str = new String();
            for(int i = 0; i < text.length(); i++) {
                str += text.charAt(i) + "";
                label.setText(str);
                try {
                    Thread.sleep(sleepTime);
                } catch(InterruptedException ex) {}
            }
    }
    
}
