package layout;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.neemshade.gitsample.R;
import com.neemshade.gitsample.interfaceInstance;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentOne extends Fragment {

    interfaceInstance mCall;


    public FragmentOne() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mCall = (interfaceInstance) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement interfaceInstance");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_fragment_one, container, false);

        final EditText sendTxt = (EditText) view.findViewById(R.id.editText_send);

        Button sendBtn = (Button) view.findViewById(R.id.button_send);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCall.sendDatafromFragOne(sendTxt.getText().toString());
            }
        });

        return view;
    }

}
