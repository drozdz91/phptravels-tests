package general.listeners;

import lombok.extern.log4j.Log4j;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

@Log4j
public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;

    private int maxRetryCount = 1;


    public String getResultStatusName(int status) {
        String resultName = null;
        if (status == 1)
            resultName = "SUCCESS";
        if (status == 2)
            resultName = "FAILURE";
        if (status == 3)
            resultName = "SKIP";
        return resultName;
    }


    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            log.info("Retrying test " + result.getName() + " with status " + getResultStatusName(result.getStatus()) + " for the " + (retryCount + 1) + " time(s).");
            retryCount++;
            return true;
        }
        return false;
    }
}
