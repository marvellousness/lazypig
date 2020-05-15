package shovel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeviceDetector {
    private Runtime r = Runtime.getRuntime();

    public void doCheck() {
        List<String> devices = getDevices();
        System.out.println("devices=" + Arrays.toString(devices.toArray()));
    }

    public List<String> getDevices() {
        List<String> arrayList = new ArrayList<>();

        try {
            Process p = r.exec("adb devices");
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (isMatch(line, "device$")) {
                    arrayList.add(getDeviceName(line, "device", ""));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return arrayList;
    }

    private Boolean isMatch(String line, String pattern) {
        Matcher m = Pattern.compile(pattern).matcher(line);

        if (m.find()) {
            return true;
        }

        return false;
    }

    private String getDeviceName(String line, String oldStr, String newStr) {
        return line.replace(oldStr, newStr).trim();
    }
}
