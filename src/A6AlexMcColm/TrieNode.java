package A6AlexMcColm;


/* Class: TrieNode
 *
 * Date: March 19th, 2022
 * 
 * Author: Alex McColm
 * 
 * Desc: Node class specially designed
 * for use in a Trie.
 */
public class TrieNode implements Comparable<TrieNode> {
    // If true, the path from root to this node forms a string contained in the Trie.
    private boolean isTerminalNode;

    // The character content of the TrieNode
    private Character key;
    
    public static final int NUM_CHARACTERS = 27; // A-Z and * - Did not end up using * as a terminal flag, so this could be cut to 26
    
    /* Subtract the char object's integer value by this constant for its place in the alphabet - 1. 
     * For instance, 'A' - CHARACTER_OFFSET = 0 
     */
    public static final int CHARACTER_OFFSET = 65;

    // Array of children - declared here, assigned value in all constructors.
    public TrieNode[] children;
    
    public TrieNode(Character newChar) {
        isTerminalNode = false;
        key = newChar;
        children = new TrieNode[NUM_CHARACTERS];
    }

    // Default constructor creates an empty node, fit for root only, or 
    // assignment with a new value shortly after.
    public TrieNode() {
        isTerminalNode = false;
        key = Character.MIN_VALUE;
        children = new TrieNode[NUM_CHARACTERS];
    }

    /* Method: setKey()
     * 
     * Input: Character object to set this node to hold
     * 
     * Output: None
     * 
     * Desc: Sets key of TrieNode. Should be used very 
     * little or not at all.
     */
    public void setKey(Character newChar) {
        key = newChar;
    }

    /* Method: getKey()
     *
     * Input: none
     * 
     * Output: Character, key of this TrieNode
     * 
     * Desc: Used A LOT by other operations
     * on Tries and TrieNodes.
     */
    public Character getKey() {
        return (char)(key + TrieNode.CHARACTER_OFFSET);
        //return (char)key;
    }

    /* Method: setIsTerminalNode()
     *
     * Input: boolean
     * 
     * Output: None
     * 
     * Desc: Sets terminal/non-terminal
     * status of this node to the boolean
     * value given
     */
    public void setIsTerminalNode(boolean isTerminalNode) {
        this.isTerminalNode = isTerminalNode;
    }

    /* Method: getIsTerminalNode()
     *
     * Input: None
     * 
     * Output: boolean value of whether
     * this node is a terminal node.
     */
    public boolean getIsTerminalNode() {
        return isTerminalNode;
    }

    /* Method: childrenEmpty()
     * 
     * Input: none
     * 
     * Output: boolean value
     * (does this node have no children?)
     *
     * Desc: Probably would be better replaced
     * by a hasChildren() function. This is reverse
     * of convention, I think.
     */
    public boolean childrenEmpty() {
        for (int i = 0; i < children.length; ++i) {
            if (children[i] != null) { 
                return false; 
            } 
        }
        return true;
    }

    @Override
    public int compareTo(TrieNode o) {
        // TODO Auto-generated method stub
        return key.compareTo(o.key);
    }

}
