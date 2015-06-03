/**********************************************************************************************************************************
 *  Ŀ¼�б�
 *  String ԭ���Զ��庯�������ַ�������ֱ�ӵ��ú��������������֤������true�����򷵻�false
 * 		1. trim        					ȥ�ո�
 * 		2. reallength 					ʵ�ʳ���
 *		3. isMobile					�ֻ������ж�
 * 		4. isTel						�绰������֤
 * 		5. isQQ						QQ������֤
 * 		6. isChinese					������֤
 *		7. validateEmail 				�����ʽ��֤
 * 		8. validateNum				��֤�ַ����Ƿ�������������
 * 		9. validateSignlessIntegral		��֤������
 * 		10.validateSignlessDecimal	��֤��ʵ��
 *		11.validateDecimal			��֤ʵ��
 * 		12.roundTwo					��֤��λС��
 * 		13.roundOne					��֤һλС��
 * 		14.validateLetter				��֤�Ƿ�����ĸ������
 *		15.validateUrl					��֤�Ƿ���URL
 * 		16.isNull						��֤�Ƿ�Ϊ��
 * 		17.check_specialword			��֤�Ƿ����JavaScript�����Ƿ��ַ� 
 * 		18.isPostCode					��֤�Ƿ�����������
 *		19.isDate						��֤�Ƿ�����ȷ�����ڸ�ʽ (ֻƥ�� 2013-02-28��ʽ)
 * 		20.isTelAreaCode				��֤�Ƿ��ǹ��ڵ绰����
 * 	
 *
 * ��ͨ��֤����������ʱ��Ҫ���ú������ƣ����ݶ�Ӧ����
 *
 * 		21.isRegisterUserName(s)  	��֤s�Ƿ��ǳ���ע���û�������ĸ�����֡��»�����ɡ���ĸ��ͷ������6-16֮�䣬ͨ����֤����true
 * 		22.checkIdcard(idcard)		��֤idcard�Ƿ�����ȷ�����֤���룬�����ַ���������Ϣ���£�
 *										"�Ϸ�",
 *										"���֤����λ�����ԣ� ĩβ�� X �����д",
 *										"���֤����������ڳ�����Χ���зǷ��ַ�! ĩβ�� X �����д",
 *										"���֤����У�����! ĩβ�� X �����д",
 *										"���֤�����Ƿ�!"
 * 
 *
 ************************************************************************************************************************************************/
	
	
	
	
	
	
/**
 * ȥ�ո�
 * @author �Ż���(2009.11.17)
 */
String.prototype.trim=function(){
 return this.replace(/(^[\s\u3000]*)|([\s\u3000]*$)/g, "");
}
/**
 * ʵ�ʳ���
 * @author �Ż���2009.11.17)
 * @return ����
 */
String.prototype.reallength=function(){
	return this.replace(/[^\x00-\xff]/g,"^^").length;
}
/**
 * �ֻ������ж�
 * @author �Ż���(2009.11.17)
 * @return �Ƿ���true,���Ƿ���false
 */
String.prototype.isMobile = function() {  
  return (/^(?:13\d|15[012356789]|18[0256789]|147)-?\d{5}(\d{3}|\*{3})$/.test(this.trim()));  
} 


/**
 * �绰������֤
 * @author �Ż���(2009.11.17)
 * @return �Ƿ���true,���Ƿ���false
 */
String.prototype.isTel = function(){
	// "���ݸ�ʽ: ���Ҵ���(2��3λ)-����(2��3λ)-�绰����(7��8λ)-�ֻ���(3λ)"
	return (/^(([0\+]\d{2,3}-)?(0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$/.test(this.trim()));
}

/**
 * QQ������֤ ��С5λ�������9λ
 * @author �Ż���(2009.11.17)
 * @return �Ƿ���true,���Ƿ���false
 */
String.prototype.isQQ = function(){
	return (/^[1-9]\d{4,8}$/.test(this.trim()));
}

/**
 * �Ƿ�������
 * @author �Ż���(2009.11.17)
 * @return �����ķ���true,�������ķ���false
 */
String.prototype.isChinese = function(){
	return (/^[\u4e00-\u9fa5]+$/.test(this.trim()));
}

/**
 * ��֤�����ʼ�
 * @author �Ż���(2009.11.17)
 * @return �Ƿ���true,���Ƿ���false
 */
String.prototype.validateEmail = function(){
	if (this.length > 100){
			return false;
	}
	var regu = "^(([0-9a-zA-Z]+)|([0-9a-zA-Z]+[_.0-9a-zA-Z-]*[0-9a-zA-Z]+))@([a-zA-Z0-9-]+[.])+([a-zA-Z]{2}|net|NET|com|COM|gov|GOV|mil|MIL|org|ORG|edu|EDU|int|INT)$"
	var re = new RegExp(regu);
	if (this.search(re) != -1) {
	   return true;
	} else {
	  
	   return false;
	}
}




/**
 * ��֤��������0
 * @author �Ż�����2009.11.24)
 * @return �Ƿ���true,���Ƿ���false
 */
String.prototype.validateNum = function(){
	return (/^(0{1}|[1-9]{1}\d*)$/.test(this.trim()));
}

/**
 * ��֤������
 * @author �����ף�2010.4.9)
 * @return �Ƿ���true,���Ƿ���false
 */
String.prototype.validateSignlessIntegral = function(){
	return (/^([1-9]{1}\d*)$/.test(this.trim()));
}
/**
 * ��֤��������
 * @author �����ף�2010.4.9)
 * @return �Ƿ���true,���Ƿ���false
 */
String.prototype.validatePricingNum = function(){
	return (/^([1-9]{1}[0-9]{0,1})$/.test(this.trim()));
}
/**
 * ��֤��ʵ��
 * @author �����ף�2010.4.9)
 * @return �Ƿ���true,���Ƿ���false 
 */
 String.prototype.validateSignlessDecimal = function(){
	return (/^\d+(\.\d+)?$/.test(this.trim()));
}
/**
 * ��֤ʵ��
 * @author ������2010.1.11)
 * @return �Ƿ���true,���Ƿ���false
 */
String.prototype.validateDecimal = function(){
	return (/^-?\d+(\.\d+)?$/.test(this.trim()));
}

/**
 * ��֤��λС��������������λ������Ϊ".5"��
 *
 * @author �ٳ�����2011.04.01)
 * @return �Ƿ���true,���Ƿ���false
 */
String.prototype.roundTwo = function(){
	return (/^\d+\.?\d{0,2}$/.test(this.trim()));
}
/**
 * ��֤һλС��������������λ������Ϊ".5��ʽ"��
 *
 * @author �ٳ�����2011.04.01)
 * @return �Ƿ���true,���Ƿ���false
 */
String.prototype.roundOne = function(){
	return (/^\d+\.?\d{0,1}$/.test(this.trim()));
}


/**
 * ��֤�Ƿ�����ĸ����
 * @author �Ż���(2009.11.17)
 * @return �Ƿ���true,���Ƿ���false
 */
String.prototype.validateLetter = function(){
	if(this.search){
		return (this.search(new RegExp("^[a-zA-Z0-9]+$","g"))>=0)
	}
}

/**
 * ��֤�Ƿ���Url
 * @author �Ż���(2009.11.17)
 * @return �Ƿ���true,���Ƿ���false
 */
String.prototype.validateUrl = function(){
	if(this.search){
		return (this.search(new RegExp("^http\:\/\/[a-zA-Z0-9\.]+(\/)$","g"))>=0)
	}
}


/**
 * �ж��Ƿ�Ϊ��
 * @author �Ż���(2009.11.17)
 * @return �Ƿ���true,���Ƿ���false
 */
String.prototype.isNull = function(){
	return (this == "" || this == null || this == "undefined");
}

/**
 * <script,select,update,delete,insert,'Ϊ�Ƿ��ַ�
 * @author �Ż���(2009.11.17)
 * @return ���Ƿ���true,�Ƿ���false
 */
String.prototype.check_specialword = function(){
	return !(/<script|select|update|delete|insert|'/ig).test(this);	
}

/**
 * ֻ�������֣����֣�Ӣ�ģ��»��ߣ��ٷֺţ���б��
 *  @author �Ż���
 * @return
 */
String.prototype.check_specialunit = function(){
	var val = /^[\u4e00-\u9fa5\w\/%]*$/; 
	return val.test(this);	
}

/**
 *  ֻ�������֣�Ӣ�ģ��»��ߣ�Ӣ����ĸ��ͷ��6-16λ������֤��������ע���û�����֤
 *  @author �Ż���
 *  @return
 */
function isRegisterUserName(s)   
{   
var patrn=/^[a-zA-Z]{1}([a-zA-Z0-9]|[._]){5,15}$/;   
	if (!patrn.exec(s)) {
		return false  ;
	}
	return true; 
} 



/**
 * ���֤��֤��ʼ
 * @author �Ż���(2009.11.17)
 * @return ������ʾ��Ϣ( var Errors )
 */

function checkIdcard(idcard){
	var Errors=new Array(
		"�Ϸ�",
		"���֤����λ�����ԣ� ĩβ�� X �����д",
		"���֤����������ڳ�����Χ���зǷ��ַ�! ĩβ�� X �����д",
		"���֤����У�����! ĩβ�� X �����д",
		"���֤�����Ƿ�!"
	);
	
	var area={11:"����",12:"���",13:"�ӱ�",14:"ɽ��",15:"���ɹ�",21:"����",22:"����",23:"������",31:"�Ϻ�",32:"����",33:"�㽭",34:"����",35:"����",36:"����",37:"ɽ��",41:"����",42:"����",43:"����",44:"�㶫",45:"����",46:"����",50:"����",51:"�Ĵ�",52:"����",53:"����",54:"����",61:"����",62:"����",63:"�ຣ",64:"����",65:"�½�",71:"̨��",81:"���",82:"����",91:"����"}

	var idcard,Y,JYM;
	var S,M;
	var idcard_array = new Array();
	
	idcard_array = idcard.split("");
	// ��������
	if(area[parseInt(idcard.substr(0,2))]==null) return Errors[4];
		// ��ݺ���λ������ʽ����
		switch(idcard.length){
			case 15:
				if ( (parseInt(idcard.substr(6,2))+1900) % 4 == 0 || ((parseInt(idcard.substr(6,2))+1900) % 100 == 0 && (parseInt(idcard.substr(6,2))+1900) % 4 == 0 )){
					ereg=/^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}$/;// ���Գ������ڵĺϷ���
				} else {
					ereg=/^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}$/;// ���Գ������ڵĺϷ���
				}
				if(ereg.test(idcard)) return Errors[0];
				else return Errors[2];
				break;
			case 18:
				// 18λ��ݺ�����
				// �������ڵĺϷ��Լ��
				// ��������:((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))
				// ƽ������:((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))
				if ( parseInt(idcard.substr(6,4)) % 4 == 0 || (parseInt(idcard.substr(6,4)) % 100 == 0 && parseInt(idcard.substr(6,4))%4 == 0 )){
					ereg=/^[1-9][0-9]{5}19[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}[0-9Xx]$/;// ����������ڵĺϷ���������ʽ
				} else {
					ereg=/^[1-9][0-9]{5}19[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}[0-9Xx]$/;// ƽ��������ڵĺϷ���������ʽ
				}
				if(ereg.test(idcard)){// ���Գ������ڵĺϷ���
					// ����У��λ
					S = (parseInt(idcard_array[0]) + parseInt(idcard_array[10])) * 7
					+ (parseInt(idcard_array[1]) + parseInt(idcard_array[11])) * 9
					+ (parseInt(idcard_array[2]) + parseInt(idcard_array[12])) * 10
					+ (parseInt(idcard_array[3]) + parseInt(idcard_array[13])) * 5
					+ (parseInt(idcard_array[4]) + parseInt(idcard_array[14])) * 8
					+ (parseInt(idcard_array[5]) + parseInt(idcard_array[15])) * 4
					+ (parseInt(idcard_array[6]) + parseInt(idcard_array[16])) * 2
					+ parseInt(idcard_array[7]) * 1
					+ parseInt(idcard_array[8]) * 6
					+ parseInt(idcard_array[9]) * 3 ;
					Y = S % 11;
					M = "F";
					JYM = "10X98765432";
					M = JYM.substr(Y,1);// �ж�У��λ
				
					if(M == idcard_array[17]) return Errors[0]; // ���ID��У��λ
					else return Errors[3];
					}
				else return Errors[2];
				break;
			default:
				return Errors[1];
				break;
		}
}
/* ���֤��֤���� */




/**
 * ����������֤
 * @author �Ż�����2009.11.24)
 * @return �Ƿ���true,���Ƿ���false
 */
String.prototype.isPostCode = function(){
	return (/^[1-9]\d{5}(?!\d)$/.test(this.trim()));
}

/**
 * ������֤
 * @author �Ż�����2009.11.24)
 * @return �Ƿ���true,���Ƿ���false
 */
String.prototype.isDate = function(){
	return (/^((?!0000)[0-9]{4}-((0[1-9]|1[0-2])-(0[1-9]|1[0-9]|2[0-8])|(0[13-9]|1[0-2])-(29|30)|(0[13578]|1[02])-31)|([0-9]{2}(0[48]|[2468][048]|[13579][26])|(0[48]|[2468][048]|[13579][26])00)-02-29)$/.test(this.trim()));
}



/**
 * У��绰�е����� ��ʽ��0XXX
 * @author �Ż�����2009.11.24)
 * @return �Ƿ���true,���Ƿ���false
 */
String.prototype.isTelAreaCode = function(){
	return (/^0\d{2,3}$/.test(this.trim()));
}

