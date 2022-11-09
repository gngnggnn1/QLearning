Description of QLearning Algorithm:

The Q-Learning algorithm goes as follows:

1. Set the gamma parameter, and environment rewards in matrix R.

2. Initialize matrix Q to zero.

3. For each episode:

Select a random initial state.

Do While the goal state hasn't been reached.

Select one among all possible actions for the current state.

Using this possible action, consider going to the next state.

Get maximum Q value for this next state based on all possible actions.

Compute: Q(state, action) = R(state, action) + Gamma * Max[Q(next state, all actions)]

Set the next state as the current state.

End Do

End For
