
package com.telephone.app;

//导入所需要使用的非默认支持数据类型的包
import com.telephone.app.PhoneBook;

interface TelephoneCallAidlServiceInterface {

   List<PhoneBook> telephoneCall(String str);

}
