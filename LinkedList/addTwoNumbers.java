import java.util.HashMap;
public class Solution {
   
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Using a HashMap to store nodes of the first linked list
        HashMap<ListNode, Integer> map = new HashMap<>();

        // Iterate through the nodes of the first linked list and store them in the map
        while (headA != null) {
            map.put(headA, map.getOrDefault(headA, 0) + 1);
            headA = headA.next;
        }

        // Iterate through the nodes of the second linked list
        while (headB != null) {
            // If the current node is in the map, it means we found the intersection
            if (map.containsKey(headB) && map.get(headB) > 0) {
                return headB;
            }
            headB = headB.next;
        }

        // No intersection found
        return null;
    }
}
