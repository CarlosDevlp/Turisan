package Model;
/**
 * Place entity
 * Created by carlos on 28/07/15.
 */
public class Place {
    private  String _photoUrl,_prevName,_name;
    public Place(){
        _prevName="";
        _name="";
    }

    //if you want to execute a piece of code When
    public void executeWhenIsNotSamePlace(String name,Function fnc){
        if(this._prevName.compareTo(name)!=0) {
            this._prevName=name;
            fnc.Execute(new String[]{});
        }
    }
    //if the place I'm is the same where I was a moment ago.
    public  boolean isSamePlace(String name){
        boolean is=_name.compareTo(name)==0;
        //assign if the name is different
            if(!is)
                this._name=name;

        return is;
    }

    public void setPhotoUrl(String url){
        _photoUrl=url;
    }
}
