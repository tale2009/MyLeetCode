public class LSWRC {
    public int lswrc(String s)
    {
        StringBuffer stringBuffer=new StringBuffer();
        int length=0;//字符串长度
        if(s.length()<2)
            return s.length();
        else
        {
            for(int i=0;i<s.length();i++)
            {
                if(stringBuffer.toString().contains(s.substring(i,i+1)) ) {
                    if(stringBuffer.length()>length)
                        length=stringBuffer.length();
                    stringBuffer=new StringBuffer(stringBuffer.substring(stringBuffer.indexOf(s.substring(i,i+1))+1,stringBuffer.length()));
                }
                stringBuffer.append(s.substring(i,i+1));
            }
            return length>stringBuffer.length()?length:stringBuffer.length();
        }
    }
}
