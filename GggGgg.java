//Note This is not complete, running this will kinda work

import java.util.*; 
import java.lang.*; 
import java.io.*; 
class GggGgg {
  public static void main(String[] args) {
    String  input = "/ / . . _ _ ' ' \" \" C GgggGgg H GgggGgG T GgggGGg a gGg c GGggG d GggG e GgG g ggGgG h GGgGg i gGGg j GgggGGG l gGGG m ggGGg n GGgGG o ggg p ggGGG r GGGg s GGGG t GGgggG u ggGgg v Ggggg w GGggggg y GGggggG GgggGGgGGgGggGGgGGGG GGggGGGgGggGggGGGgGGGGgGGGgGGggGgGGgG GGggggggGgGGGG ggGGGGGGggggggGGGgggGGGGGgGGggG gGgGGgGGGggG GggGgGGgGGGGGGggGggGggGGGGGGGGGgGGggG gggGggggGgGGGGg gGgGGgggG /GGGg/GggGgGggGGggGGGGGggggGggGGGGGGggggggGgGGGGggGgggGGgggGGgGgGGGGg_gGGgGggGGgGgGgGGGG. GgggGgGgGgGggggGgG gGg GGggGgggggggGGG GGggGGGgGggGggGGGgGGGGgGGGgGGggGgGGgG gGGgGggGGgGgGg? GgggGgggggggGGgGgG GgggGGGggggGGgGGgGG ggGggGGGG gggGggggGgGGGGg GGgggGGGgGgGgGGGGgGgG!";
    String[] translate = {}, insplit = input.split(" ");
    int translatelen=0, spaces =0;
    
    ArrayList<String[]> Dictionary = new ArrayList<String[]>();
    for(int i = 0; i< insplit.length; i++)
    {
      if(insplit[i].length()==1)
      {
        String[] temp = {insplit[i], insplit[i+1]};
        Dictionary.add(temp);
        i++;
      }
      else
      { 
        translate = new String[insplit.length-(i)];
        for(int j = 0; j < translate.length; j++)
        {
          spaces++;
          translatelen+= insplit[i+j].length();
          translate[j] = insplit[i+j];
        }
        System.out.println(translatelen);
        i+= insplit.length-(i);
      }
    }
    Collections.sort(Dictionary, new Sortbyroll()); 
    for(int i = 0; i< Dictionary.size(); i++)
    {
        System.out.println(Dictionary.get(i)[0] + " " + Dictionary.get(i)[1]);
    }
    //each of the large blocks of translateable g's
    ArrayList<String> translated = new ArrayList<String>();
    for(int v=0;v<14;v++)
    {
      for(int c = 0; c< translate[v].length();c++)
      {
        for(int i = 0; i < Dictionary.size();i++)
        {
          boolean temp =translate[v].regionMatches(0, Dictionary.get(i)[1], 0, Dictionary.get(i)[1].length());
          if(temp == true)
          {
            translated.add(Dictionary.get(i)[0]);
            translate[v] = translate[v].replaceFirst(Dictionary.get(i)[1],"");
          }
        }
        for(int i = 0; i< translated.size();i++)
        {
            System.out.print(translated.get(i));
        }
        System.out.println(translate[v]);
      }
      translated.add(" ");
    }
  }
}
class Sortbyroll implements Comparator<String[]> 
    {  
      // Used for sorting in ascending order of 
      // roll number 
      public int compare(String[] a, String[] b) 
      { 
          return a[1].length()- b[1].length(); 
      } 
    }

