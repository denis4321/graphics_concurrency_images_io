package welcome;

import java.io.File;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2009</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class FileFinder {
  private long amountOfFiles;
  /*   ����� ��� ������ ����� � ���������� ����� nameOfFileIsSearching,
    � �������� ����� ��� ������ topDirectory,
    ������ ��� �������� ���������� ��-�� reultList
   */
  public List search(File topDirectory, String nameOfFileIsSearching, List resultList){
    File[] listOfFiles = topDirectory.listFiles();
    try{
      long n=listOfFiles.length;
      for (int i=0;i<n;i++){
        if (listOfFiles[i].isDirectory()){
          //�������� �������������� ���������� ������
          doesItSutisfactNameOfParameters(resultList,listOfFiles[i],nameOfFileIsSearching);
          //����� �� ��������� ������
          search(listOfFiles[i],nameOfFileIsSearching,resultList);
        }
        else { doesItSutisfactNameOfParameters(resultList,listOfFiles[i],nameOfFileIsSearching);}
      }
    }
    catch (NullPointerException e){
    }
    amountOfFiles=resultList.size();
    return resultList;
  }

  //����� ��� �������� ��� �������� �������������� ���������� ������
  private void doesItSutisfactNameOfParameters(List thatResultList,File fileIsChecking,String name){
    if (fileIsChecking.getName().contains(name)){
      thatResultList.add(fileIsChecking);
    }
  }

  //����� ��� ������� ���������� ���������� � �������� �� �������������
  private List find(String pathName, String name) throws Exception {
    File topDirectory = new File(pathName);
    if (!topDirectory.exists()) throw new Exception("������:��������� ���� �� ����������");
    ArrayList resultList = new ArrayList();
    search(topDirectory,name, resultList);
    return resultList;
  }

  public List findFile(String pathName,String name) throws Exception {
    return find(pathName, name);
  }

  //������ ��� ����������� ���-�� ������
  public long getTotalLength(){
    return amountOfFiles;
  }

}
