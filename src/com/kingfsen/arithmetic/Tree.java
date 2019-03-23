package com.kingfsen.arithmetic;

public class Tree {
    public Node root;

    public Tree() {

    }

    //insert one new node
    public void insert(int data) {
        Node node = new Node(data);
        if (root == null) {
            root = node;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (current.data > data) {
                    current = current.left;
                    if (current == null) {
                        parent.left = node;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = node;
                        return;
                    }
                }
            }
        }
    }

    public Node findMax() {
        Node current = root;
        Node parent = null;
        while (current != null) {
            parent = current;
            current = current.right;
        }
        return parent;
    }

    public Node findMin() {
        Node current = root;
        Node parent = null;
        while (current != null) {
            parent = current;
            current = current.left;
        }
        return parent;
    }

    public Node find(int data) {
        Node current = root;
        while (current.data != data) {
            if (current.data > data) {
                current = current.left;
            } else {
                current = current.right;
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    public Node findSuccessor(Node node) {
        Node successorParent = node;
        Node successor = node;
        Node current = node.right;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.left;
        }
        if (successor != node.right) {
            successorParent.left = successor.right;
            successor.right = node.right;
        }
        return successor;
    }

    public boolean delete (int data) {
        Node current = root;
        Node parent = root;
        boolean left = false;
        while (current.data != data) {
            parent = current;
            if (current.data > data) {
                current = current.left;
                left = true;
            } else {
                current = current.right;
                left = false;
            }
            //not find special node
            if (current == null) {
                return false;
            }
        }
        //leaf node
        if (current.left == null && current.right == null) {
            //maybe want to delete the whole tree
            if (current == root) {
                root = null;
            } else if (left) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        //one children node
        } else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (left) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (left) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        //two children node
        } else {
            Node successor = findSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (left) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }
}

class Node {
    public Node left;
    public Node right;
    public int data;

    public Node() {

    }

    public Node(int data) {
        this.data = data;
    }

    public boolean equals(Node node) {
        if (node == null) {
            return false;
        }
        return node.data == this.data;
    }
}
