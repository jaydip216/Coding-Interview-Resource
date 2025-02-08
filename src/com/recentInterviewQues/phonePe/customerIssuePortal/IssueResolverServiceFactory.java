package com.recentInterviewQues.phonePe.customerIssuePortal;

public class IssueResolverServiceFactory {

    public static IssueResolverService getIssueResolverService(final IssueType issueType){
        switch (issueType){
            case GOLD:
                return new GoldIssueResolverService();
            case PAYMENT:
                return new PaymentIssueResolverServiceImpl();
            case MUTUATL_FUND:
                return new MutualFundsIssueResolverService();
            case ISURANCE:
                return new InsuranceIssueResolverService();
            default:
                // invalid type
                return null;

        }
    }
}
