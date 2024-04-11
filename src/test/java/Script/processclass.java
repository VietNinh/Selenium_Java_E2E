package Script;

import java.io.IOException;

public class processclass{
    Process getBrowserProcess() {
        Process p = null;
        try {
            p = Runtime.getRuntime()
                    .exec("D:\\A\\Money\\Airdrop\\ACC01\\GoogleChromePortable\\GoogleChromePortable.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return p;
    }

}