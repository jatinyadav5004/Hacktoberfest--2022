#include <iostream>
using namespace std;

int main() {
	// your code goes here
	float t,k,a,b,x,y;
	cin>>t;
	for(k=1;k<=t;k++)
	{
	    cin>>a>>b>>x>>y;
	    a=a/x;
	    b=b/y;
	    if(a<b)
	    cout<<"Chef"<<endl;
	    else if(b<a)
	    cout<<"Chefina"<<endl;
	    else
	    cout<<"Both"<<endl;
	}
	return 0;
}
