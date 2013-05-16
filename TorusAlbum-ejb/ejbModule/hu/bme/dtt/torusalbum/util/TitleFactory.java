package hu.bme.dtt.torusalbum.util;

import java.util.Collections;
import java.util.List;

public class TitleFactory {

	public static List<Tag> getMetaTags() {

		return null;
	}

	public static List<Tag> getWebPageNames() {

		return null;
	}

	
	public static List<Tag> getWebMetaTags(){
		
		return null;
	}
	
	public static List<Tag> unioTagLists(List<List<Tag>> webMetaTagLists){
		List<Tag> resultTags=webMetaTagLists.get(0);
		for(int i=1; i< webMetaTagLists.size(); i++){
			for(Tag t : webMetaTagLists.get(i)){
				for(Tag resultTag : resultTags){
					if(t.getName().equals(resultTag.getName())){
						resultTag.raisCounter();
					} else {
						resultTags.add(t);
					}
				}
			}
		}
		Collections.sort(resultTags);
		return resultTags;
	}
	
	

}
