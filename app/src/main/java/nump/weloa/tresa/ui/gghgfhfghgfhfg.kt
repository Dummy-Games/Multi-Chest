package nump.weloa.tresa.ui

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import nump.weloa.tresa.R
import nump.weloa.tresa.util.fgdgdhdf
import nump.weloa.tresa.util.fggfdhfddfgfdgdf
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine
import kotlin.random.Random
import kotlin.random.nextInt

class gghgfhfghgfhfg : Fragment(R.layout.bfhdfgfd) {

    private var fdhyjrrjjggj: Job? = null
    private var fggdgfd = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fdgffdgdhgd(view)
        view.findViewById<Button>(R.id.button).setOnClickListener { fdgffdgdhgd(view) }
    }

    private fun fdgffdgdhgd(view: View) {
        fdhyjrrjjggj?.cancel()
        with(view) {
            val ivContainer = findViewById<FrameLayout>(R.id.flImages)
            fdhyjrrjjggj = viewLifecycleOwner.lifecycleScope.launch {
                listOf<ImageView>(
                    findViewById(R.id.iv1),
                    findViewById(R.id.iv2),
                    findViewById(R.id.iv3),
                    findViewById(R.id.iv4)
                ).fggfdhfddfgfdgdf { gfbhdfhfd(it, ivContainer) }.forEach {
                    it.join()
                }
                Snackbar.make(requireView(), "You won!", Snackbar.LENGTH_LONG).show()
            }
        }
    }

    private suspend fun gfbhdfhfd(iv: ImageView, container: FrameLayout): Job {
        iv.isVisible = true
        iv.setImageResource(requireContext().fgdgdhdf("f" + Random.nextInt(1..4)))
        iv.scaleX = 1f
        iv.scaleY = 1f
        iv.x = container.width * Random.nextInt(20) * 0.04f
        iv.y = container.height * Random.nextInt(20) * 0.04f
        iv.animate()
            .scaleY(0f)
            .scaleX(0f)
            .setDuration(5_000L)
            .start()
        return withContext(Dispatchers.Main) { launch { zgffdhdhfdh(iv) } }
    }

    private suspend fun zgffdhdhfdh(iv: ImageView) = suspendCoroutine<Unit> { cont ->
        iv.setOnClickListener {
            fggdgfd += 100
            view?.findViewById<TextView>(R.id.tvScore)?.text = "SCORE: $fggdgfd"
            iv.isVisible = false
            cont.resume(Unit)
        }
    }
}
