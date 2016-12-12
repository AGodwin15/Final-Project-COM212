//Serialize, put this right before quitting the program

  try {
	FileOutputStream fileOut = new FileOutputStream("output.txt");
	ObjectOutputStream out = new ObjectOutputStream(fileOut);
	out.writeObject(BST);
	out.writeObject(QueueA);
	out.writeObject(Heap);
	out.writeObject(BST2)
	out.close();
	fileOut.close();
	System.out.println("Serialized object successfully in output.txt");
	} 
          catch(IOException i) {
	  i.printStackTrace();
	}
//and for the out.writeObject(<write your database names here>)



//De-serialize, put this at the beginning when you want to load something pre-saved in,
  //      note: it might error out if the text file doesn't exsist/ was wiped from RAM

try {
	FileInputStream fileIn = new FileInputStream("output.txt");
	ObjectInputStream in = new ObjectInputStream(fileIn);
	BST = (StudentBST) in.readObject();
	QueueA = (IdeaQueue) in.readObject();
	Heap = (IdeaHeap) in.readObject();
	BST2 = (StudentBST2) in.readObject();  
	in.close();
	fileIn.close();
	} 
	catch(IOException i) {
	i.printStackTrace();
	} 
	catch(ClassNotFoundException j) {
	j.printStackTrace();
	}
//Note: for these^, BST, QueueA, etc are new objects we are assiging the stuff from the text file
//Contact GitHub API Training Shop Blog About
