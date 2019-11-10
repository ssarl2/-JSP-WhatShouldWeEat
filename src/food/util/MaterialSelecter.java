package food.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import food.table.Food;

public class MaterialSelecter {
	public String question(ArrayList<Food> foods, ArrayList<String> pastAnswer)
	{
		String mtrTmp = "";
		Iterator<Food> ItF = foods.iterator();
		while(ItF.hasNext()) // 특징들 몰아넣기
		{
			mtrTmp += ItF.next().getMaterial()+",";
		}
		String mtrArr[] = mtrTmp.split(",");
		
		Map<String,Integer> mtrHash = new HashMap<String,Integer>();
		for(int i=0;i<mtrArr.length;i++) //속성의 중복 체크 및 수량 체크
		{
			if(isPast(mtrArr[i], pastAnswer)) // 과거 질문과 겹치는지 확인
			{
				//넘김
			}
			else
			{
				if(!mtrHash.containsKey(mtrArr[i]))
				{
					mtrHash.put(mtrArr[i],1);
				}
				else
				{
					mtrHash.put(mtrArr[i],mtrHash.get(mtrArr[i])+1);
				}
			}
		}
		
		Iterator<String> ItM = mtrHash.keySet().iterator();
		int near = foods.size()/2; //나누기 2, 음식 수의 중간 값(유저가 질문을 하면 나눠질 음식 수)
		int min = Integer.MAX_VALUE;
		String mindata = "";
		Random random = new Random();
		while(ItM.hasNext()) // 근삿값 알고리즘 
		{
			String key = ItM.next();
			int tmp = Math.abs(mtrHash.get(key)-near); 
			if(min > tmp)
			{
				min = tmp;
				mindata = key;
			}
			else if(min == tmp)
			{
				if(random.nextBoolean())
				{
					mindata = key;
				}
			}
		}
		return mindata; //근삿값과 제일 근접한 질문(특징) 반환
	}
	
	public ArrayList<Food> select(ArrayList<Food> selects, String question, boolean answer) 
	{
		for(int i=0;i<selects.size();i++)
		{
			Food food = selects.get(i);
			boolean chk = false;
			String mtrArr[] = food.getMaterial().split(",");
			for(int j=0;j<mtrArr.length;j++)
			{
				if(mtrArr[j].equals(question)) // 특성중 있는지 없는지 확인
					chk = true;
			}
			
			if(chk != answer)
			{
				selects.remove(i);
			}
		}
		
		return selects;
	}
	
	private boolean isPast(String material,ArrayList<String> pastAnswer)
	{
		boolean chk = false;
		for(int i=0;i<pastAnswer.size();i++)
		{
			if(material.equals(pastAnswer.get(i)))
				chk = true;
		}
		return chk;
	}

}
