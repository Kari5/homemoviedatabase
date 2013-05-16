package hu.bme.dtt.torusalbum.util;

import hu.bme.dtt.torusalbum.entity.Album;
import hu.bme.dtt.torusalbum.entity.Picture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TitleFactory {

	public static List<Tag> getPictureMetaTags(String url) {
		List<Tag> resultTags=new ArrayList<Tag>();
		Random r=new Random();
		for(int i=0; i<10; i++){
			resultTags.add(new Tag(""+r.nextInt(10)));
		}
		return resultTags;
	}

	public static List<Tag> getWebPageNames(String url) {
		List<Tag> resultTags=new ArrayList<Tag>();
		Random r=new Random();
		for(int i=0; i<10; i++){
			resultTags.add(new Tag(""+r.nextInt(10)));
		}
		return resultTags;
	}

	
	public static List<Tag> getWebMetaTags(String url){
		List<Tag> resultTags=new ArrayList<Tag>();
		Random r=new Random();
		for(int i=0; i<10; i++){
			resultTags.add(new Tag(""+r.nextInt(10)));
		}
		return resultTags;
	}
	
	public static List<Tag> unioTagLists(List<List<Tag>> webMetaTagLists){
		List<Tag> resultTags=new ArrayList<Tag>();
		for(List<Tag> tagList: webMetaTagLists){
			for(Tag t : tagList){
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
	
	public static List<Tag> getTitels(Album album){
		List<Tag> result=new ArrayList<Tag>();
		if(album==null){
			return result;
		}
		List<List<Tag>> picutreTags=new ArrayList<List<Tag>>();
		List<List<Tag>> webPageTags=new ArrayList<List<Tag>>();
		List<List<Tag>> webPageNameTags=new ArrayList<List<Tag>>();
		for(Picture p : album.getPictures()){
			List<Tag> pictureTagList=getPictureMetaTags(p.getUrl());
			List<Tag> webTagList=getPictureMetaTags(p.getUrl());
			List<Tag> webNameTagList=getPictureMetaTags(p.getUrl());
			picutreTags.add(pictureTagList);
			webPageTags.add(webTagList);
			webPageNameTags.add(webNameTagList);
		}
		List<Tag> pictureTag=unioTagLists(picutreTags);
		List<Tag> webPageTag=unioTagLists(webPageTags);
		List<Tag> webPageNameTag=unioTagLists(webPageNameTags);
		
		
		result.addAll(webPageNameTag);
		result.addAll(webPageTag);
		result.addAll(pictureTag);
		
		Collections.sort(result);
		return result;
	}
	

}
